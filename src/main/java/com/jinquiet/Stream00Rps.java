package com.jinquiet;

import java.util.logging.Logger;

import com.jinquiet.game.RpsGameService;
import com.jinquiet.game.gamerules.Rps;
import com.jinquiet.game.model.RpsGameModel;
import com.jinquiet.logger.LoggerWrapper;

public class Stream00Rps {
    private final static Logger logger = LoggerWrapper.getLogger(Stream02.class);    

    public void workWithStreamRPS() {

        RpsGameModel rgm = new RpsGameService().play(Rps.ROCK.name());
        logger.info(String.valueOf(rgm));

    }
}
