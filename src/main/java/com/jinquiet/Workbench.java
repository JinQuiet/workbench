package com.jinquiet;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jinquiet.exception.IntegerValidationException;
import com.jinquiet.json.Payload;
import com.jinquiet.validator.ValidationChain;
import com.jinquiet.validator.ValidationResult;
import com.jinquiet.validator.Validator;
import com.jinquiet.validator.impl.AgeValidator;
import com.jinquiet.validator.impl.EmailValidator;
import com.jinquiet.validator.impl.IntegerValidator;
import com.jinquiet.validator.impl.NameValidator;
import com.jinquiet.validator.impl.web.PathValidator;
import com.jinquiet.validator.impl.web.RequestMethodValidator;
import com.jinquiet.web.mapping.PathParamToRegexPool;
import com.jinquiet.web.mapping.RequestMapping;
import com.jinquiet.web.mapping.RequestMappingPool;
import static com.jinquiet.web.util.WebUtils.*;

/**
 * Workbench
 *
 */
public class Workbench {

    static String pathInfo;
    static String requestMethod;
    public static void main(String[] args) throws InterruptedException, IntegerValidationException {
        PrintStream so = System.out;

        so.format("====================Workbench==============%n");

        so.format("====================Validator Test END==============%n");

        User user = new User();
            user.setUsername("Max");
            user.setEmail("234234 qweqwe.com");
            user.setUserAge("1000");

        Validator<String> iv = new IntegerValidator("user.id");
        Validator<String> nv = new NameValidator("user.userName");
        Validator<String> ev = new EmailValidator("user.email");
        Validator<String> av = new AgeValidator("user.userAge");

        //chain strarts.
        ValidationChain<String> vc = new ValidationChain<>();

        ValidationResult chainResolutionResult = vc.nextLink("00000", iv)
                .nextLink(user.getUsername(), nv)
                .nextLink(user.getUserAge(), av)
                .nextLink(user.getEmail(), ev)
                .resolve();

        so.println("chainResolution :: " + chainResolutionResult);

            Payload<User> p = new Payload<User>(user, vc.getErrorMessages());

            ObjectMapper mapper = new ObjectMapper();
            try {
                String json = mapper.writeValueAsString(p);
                so.println("ResultingJSONstring = " + json);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        so.format("====================Validator Test END==============%n");

        so.format("====================Request Mapping Test==============%n");

        pathInfo = "/users/123/test/223424/vfvfv/34";
        requestMethod = "GET";

        pathInfo = getCleanPath(pathInfo);

        ValidationChain<String> pathValidationChain = new ValidationChain<>();

            Validator<String> pv = new PathValidator("request.path", RequestMappingPool.getRequestMapping());
                pathValidationChain.nextLink(pathInfo, pv);
                    List<RequestMapping> pathMapping 
                    = getMappingForRequestPart(RequestMappingPool.getRequestMapping(), 
                    pathInfo,
                    (rm) -> pathInfo.matches(pathParamToRegex(PathParamToRegexPool.getPathParamToRegexMapping(), rm.getPath())));

            Validator<String> requestMethodValidator = new RequestMethodValidator("request.method", pathMapping);
                pathValidationChain.nextLink(requestMethod, requestMethodValidator);
                    pathMapping
                    = getMappingForRequestPart(pathMapping, 
                    requestMethod,
                    (rm) -> requestMethod.equals(rm.getRequestMethod()));


        ValidationResult prr = pathValidationChain.resolve();
            

        Payload<User> plu = new Payload<User>(user, pathValidationChain.getErrorMessages());
        so.println("chainResolution :: " + prr.isValid());
        so.println("chainErrors :: " + pathValidationChain.getErrorMessages());

        try {
            String json = mapper.writeValueAsString(plu);
            so.println("ResultingJSONstring = " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        so.format("====================Request Mapping Test END==============%n");

        so.format("====================Request-Tokenizer==============%n");        

        Arrays.stream(tokenizePath(pathInfo)).forEach(so::println);

    }
}