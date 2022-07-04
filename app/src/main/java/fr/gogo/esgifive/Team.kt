package fr.gogo.esgifive



class Team(val name: String, var players : ArrayList<Player>){
    fun getPlayers(): String{
        var s: String = "["
        for(player in players){
            s+= player.name + ", "
        }
        s+= "]"
        return s
    }

    fun haveBall():Boolean{
        for(player in players){
            if(player.haveBall){
                //println(this.name + " have the ball")
                return true
            }
        }
        return false
    }

    fun getPlayerWithBall():Player{
        for(player in players){
            if(player.haveBall){
                //println(player.name + " have the ball")
                return player
            }
        }
        return null!!
    }

    fun getGoalKeeper():Player{
        for(player in players){
            if(player.isGoal){
                return player
            }
        }
        return null!!
    }
}