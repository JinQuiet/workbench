package com.jinquiet.generic;

import java.util.logging.Logger;

import com.jinquiet.logger.LoggerWrapper;

public class RecursiveGenericDemo {
    private final static Logger logger = LoggerWrapper.getLogger(RecursiveGenericDemo.class);

    public void go() {
        logger.info("===============Recursive Generic Demo========");

        /*
            Here is where you can encounter Recoursive Generics in original Java code
            java.util.stream.BaseStream;
            java.util.stream.Stream;
            java.lang.Enum
        */

        /*
        * Here is how you can creaate fluent builder with Recoursive Generics
        * Using inhericatance chain with the interfaces
        * - "new MechDeployerRunner" is used instead of "new MechDeployer" since
        * - in the MechDeployer you need to specify 2 type parameters instead of 1
        * - and the 2 type parameter is used to bootsrap onto inheritance chain
        * - when you use this type of builder you need to bootstrap ontoo the chain automatically
        * - and MechDeployerRunner does just that
        * As with all fluent builders, any building method can be added anywhere in the build chain
        */
        Mech mech =
            new MechDeployerRunner<String>()
                .finetune("tuning")
                .deploy("deployed")
                .assemble("assempled")
                .group("grouped")
                .build();

        logger.info(mech.toString());

        /*
        * SuperMechDeployer is derived from MechDeployer
        * and has 1 additional method "update()"
        * adding "Additional Gloss" to finetune() method
        * As with all fluent builders, it can be added anywhere in the build chain
        */
        Mech mech01 = new SuperMechDeployerRunner<String>()
                .finetune("tuning")
                .deploy("deployed")
                .assemble("assempled")
                .update()   //new method in the derived class
                .group("grouped")
                .build();


        logger.info(mech01.toString());
    }
}

/*
* interfaces are inherited sequentially 
* Assemble -> FineTune -> Deploy-> Group
*/
interface Assemble<M, T extends Assemble<M, T>> {
    public T assemble(M m);
}

interface FineTune<M, T extends FineTune<M, T>> extends Assemble<M, T> {
    public T finetune(M m);
}

interface Deploy<M, T extends Deploy<M, T>> extends FineTune<M, T> {
    public T deploy(M m);
}

interface Group<M, T extends Group<M, T>> extends Deploy<M, T> {
    public T group(M m);
}

/*
* implements interface chain "Assemble -> FineTune -> Deploy-> Group"
* binding to the last link of the chain "Group" interface
*   
* Ugly thing
* You need to explicitly suppress warnings for upcasting cases
*/
class MechDeployer<M, T extends MechDeployer<M, T>> implements Group<M, T> {

    protected Mech mech;

    MechDeployer(){
        this.mech = new Mech();
    }

    public Mech build() {
        return this.mech;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T assemble(M m) {
        mech.setAssemble(String.valueOf(m));
        return (T)this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T  finetune(M m) {
        mech.setFinetune(String.valueOf(m));
        return (T)this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T deploy(M m) {
        mech.setDeploy(String.valueOf(m));
        return (T)this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T group(M m) {
        mech.setGroup(String.valueOf(m));
        return (T)this;
    }
}
/*
* unfortunately you need Runner class to use the builder
* this is the case since you don't really need the second type paramerter
* and in "return (T)this" has to be type parameter derived from MechDeployer
* So I just use MechDeployerRunner as this parameter in this class
* and continue to use only first type paramter
*/
class MechDeployerRunner<M> extends MechDeployer<M, MechDeployerRunner<M>> {
}

/*
* extends class MechDeployer without braking building chain properties
* you can still add new methods to the chain and use the old ones
* like you were before
*
* Ugly thing
* You need to explicitly suppress warnings for upcasting cases
*/
class SuperMechDeployer<M, T extends SuperMechDeployer<M,T>> extends MechDeployer<M,SuperMechDeployer<M,T>>  {

    @SuppressWarnings("unchecked")
    public T update() {
        mech.setFinetune(mech.getFinetune() + "+Additional Gloss");
        return (T)this;
    }
}

/*
* Secod runner class for the derived SuperMechDeployer
* reason for it's existence are the same as in the first case
*/
class SuperMechDeployerRunner<M> extends SuperMechDeployer<M, SuperMechDeployerRunner<M>> {
}

/*
Just some Mech class with a bunch of string fields
*/
class Mech {
    private String assemble;
    private String finetune;
    private String deploy;
    private String group;

    public String getAssemble() {
        return assemble;
    }
    public void setAssemble(String assemble) {
        this.assemble = assemble;
    }
    public String getFinetune() {
        return finetune;
    }
    public void setFinetune(String finetune) {
        this.finetune = finetune;
    }
    public String getDeploy() {
        return deploy;
    }
    public void setDeploy(String deploy) {
        this.deploy = deploy;
    }
    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Mech [assemble=" + assemble + ", deploy=" + deploy + ", finetune=" + finetune + ", group=" + group
                + "]";
    }
}