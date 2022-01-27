package com.jinquiet.game.model;

public class RpsGameModel {
    private String playerAction;
    private String opponentAction;
    private String gameResult;

    public String getPlayerAction() {
        return playerAction;
    }
    public void setPlayerAction(String playerAction) {
        this.playerAction = playerAction;
    }
    public String getOpponentAction() {
        return opponentAction;
    }
    public void setOpponentAction(String opponentAction) {
        this.opponentAction = opponentAction;
    }
    public String getGameResult() {
        return gameResult;
    }
    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }
    
    @Override
    public String toString() {
        return 
            "RpsGameModel [gameResult=" + gameResult + 
            ", playerAction=" + playerAction + 
            ", opponentAction=" + opponentAction + 
            "]";
    }
}