package fr.gogo.esgifive

import kotlin.random.Random


class Match(val team1: Team, val team2: Team, var score_team1: Int = 0, var score_team2: Int = 0, var end_time: Int = 90){
    var current_time = 0
    var teams = listOf(team1,team2)
    val MAX_PASS = 5

    fun incrementScore(t: Team){
        if(t==team1){score_team1++}
        else{score_team2++}
    }

    fun start(firstStart: Boolean = true){
        if(!firstStart){//donc donner la balle à l'equipe qui vient d'encaisser
            getTeamWithBall().getPlayerWithBall().leaveBall()
            getTeamWithBall(false).players.random().takeBall()

        }else{ //premier engagement, donc donner balle au hasard
            teams.random().players.random().takeBall()
        }
    }

    fun getTeamWithBall(b: Boolean = true):Team{
        if(team1.haveBall() == b){ return team1 }
        return team2
    }

    fun getOppositeGoal():Player{
        val team_without_ball = getTeamWithBall(false)
        return team_without_ball.getGoalKeeper()
    }

    fun actionBeforeShoot():Boolean {
        var team = getTeamWithBall()
        for (nbPass in 1..Random.nextInt(1,MAX_PASS)){
            team.getPlayerWithBall().pass(team.players.random())
        }
        return true
    }

    fun game(){
        start()
        if(actionBeforeShoot() && (score_team1 < 5 || score_team2 < 5) ){
            var but = getTeamWithBall().getPlayerWithBall().scoreGoal(getOppositeGoal())
            if (but){
                incrementScore(getTeamWithBall())
                start(false)
            }
        }
    }

    fun current_score():String{
        return team1.name + " (" + score_team1 + " - " + score_team2 + ") " + team2.name
    }
}
