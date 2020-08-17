package com.gidp.sure3odds.controller;

import com.gidp.sure3odds.entity.games.*;
import com.gidp.sure3odds.entity.response.BaseResponse;
import com.gidp.sure3odds.entity.users.NewGameAndPrediction;
import com.gidp.sure3odds.service.games.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/sure3odds")
@RestController
public class GamesController {
    @Autowired
    SetsService setsService;

    @Autowired
    LeaguesService leaguesService;

    @Autowired
    CountriesService countriesService;

    @Autowired
    TeamsService teamsService;

    @Autowired
    PredictionsService predictionsService;

    @Autowired
    GamesService gamesService;




    @PostMapping("/games/country/createall")
    ResponseEntity<?> createCountries(@RequestBody List<Countries> listContries) {
        BaseResponse response = countriesService.CreateAllCountry(listContries);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/games/country/create")
    ResponseEntity<?> createCountry(@RequestBody Countries countries) {
        BaseResponse response = countriesService.CreateCountry(countries);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/games/country/update")
    ResponseEntity<?> updateCountry(@RequestBody Countries countries) {
        BaseResponse response = countriesService.UpdateCountry(countries);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/games/country/getall")
    ResponseEntity<?> getAllCountries() {
        BaseResponse response = countriesService.GetAllCountries();
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/games/country/get_by_id/{id}")
    ResponseEntity<?> getCountryByID(@RequestParam Long id) {
        BaseResponse response = countriesService.GetCountryByID(id);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/games/country/delete/{id}")
    ResponseEntity<?> deleteCountry(@RequestParam Long id) {
        BaseResponse response = countriesService.DeleteCountry(id);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/games/country/search_by_name/")
    ResponseEntity<?> searchCountryByName(@RequestParam String country) {
        BaseResponse response = countriesService.SearchCountries(country);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }















    @PostMapping(value = "/games/set/create")
    ResponseEntity<?> createSet(@RequestBody Sets sets) {
        BaseResponse response = setsService.CreateSet(sets);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/games/set/update")
    ResponseEntity<?> updateSet(@RequestBody Sets sets) {
        BaseResponse response = setsService.UpdateSet(sets);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/games/set/getall")
    ResponseEntity<?> getAllSets() {
        BaseResponse response = setsService.GetAllSets();
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/games/set/get_by_id/{id}")
    ResponseEntity<?> getSetByID(@RequestParam Long id) {
        BaseResponse response = setsService.GetSetByID(id);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/games/set/delete/{id}")
    ResponseEntity<?> deleteSet(@RequestParam Long id) {
        BaseResponse response = setsService.DeleteSet(id);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }








    @PostMapping(value = "/games/league/create")
    ResponseEntity<?> createLeague(@RequestBody Leagues leagues) {
        BaseResponse response = leaguesService.CreateLeague(leagues);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/games/league/update")
    ResponseEntity<?> updateLeague(@RequestBody Leagues leagues) {
        BaseResponse response = leaguesService.UpdateLeague(leagues);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/games/league/getall")
    ResponseEntity<?> getAllLeagues() {
        BaseResponse response = leaguesService.GetAllLeagues();
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/games/league/get_by_id/{id}")
    ResponseEntity<?> getLeagueByID(@RequestParam Long id) {
        BaseResponse response = leaguesService.GetLeagueByID(id);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/games/league/search_by_countryid/{id}")
    ResponseEntity<?> searchLeagueByCountryID(@RequestParam Long id) {
        BaseResponse response = leaguesService.GetLeagueByCountryID(id);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/games/league/search_by_name")
    ResponseEntity<?> searchLeagueByName(@RequestParam String name) {
        BaseResponse response = leaguesService.SearchLeaguesByName(name);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/games/league/delete/{id}")
    ResponseEntity<?> deleteLeague(@RequestParam Long id) {
        BaseResponse response = leaguesService.DeleteLeague(id);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }












    @PostMapping("/games/team/createall")
    ResponseEntity<?> createTeams(@RequestBody List<Teams> listTeams) {
        BaseResponse response = teamsService.CreateAllTeams(listTeams);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/games/team/create")
    ResponseEntity<?> createTeam(@RequestBody Teams teams) {
        BaseResponse response = teamsService.CreateTeam(teams);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/games/team/update")
    ResponseEntity<?> updateTeam(@RequestBody Teams teams) {
        BaseResponse response = teamsService.UpdateTeam(teams);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/games/team/getall")
    ResponseEntity<?> getAllTeams() {
        BaseResponse response = teamsService.GetAllTeams();
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/games/team/get_by_id/{id}")
    ResponseEntity<?> getTeamByID(@RequestParam Long id) {
        BaseResponse response = teamsService.GetTeamByID(id);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/games/team/get_by_countryid/{id}")
    ResponseEntity<?> getTeamsByCountryID(@RequestParam Long id) {
        BaseResponse response = teamsService.GetTeamsByCountryID(id);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/games/team/search_by_name")
    ResponseEntity<?> searchTeamsByName(@RequestParam String name) {
        BaseResponse response = teamsService.SearchTeamsByName(name);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/games/team/get_by_leagueid/{id}")
    ResponseEntity<?> getTeamsByLeagueID(@RequestParam Long id) {
        BaseResponse response = teamsService.GetTeamsByLeagueID(id);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/games/team/delete/{id}")
    ResponseEntity<?> deleteTeam(@RequestParam Long id) {
        BaseResponse response = teamsService.DeleteTeam(id);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }










    @PostMapping(value = "/games/prediction/create")
    ResponseEntity<?> createPrediction(@RequestBody NewGameAndPrediction newGameAndPrediction) {
        BaseResponse response =  predictionsService.CreatePrediction(newGameAndPrediction);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping(value = "/games/prediction/update")
    ResponseEntity<?> updatePrediction(@RequestBody Predictions predictions) {
        BaseResponse response = predictionsService.UpdatePrediction(predictions);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/games/prediction/getall")
    ResponseEntity<?> getAllPredictions() {
        BaseResponse response = predictionsService.GetAllPredictions();
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/games/prediction/get_by_id/{id}")
    ResponseEntity<?> getPredictionByID(@RequestParam long id) {
        BaseResponse response = predictionsService.GetPredictionByID(id);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/games/prediction/get_by_date/")
    ResponseEntity<?> getAllPredictionByDate(@RequestParam() @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE) Date matchDate) {
        BaseResponse response = predictionsService.GetAllPredictionByDate(matchDate);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping(value = "/games/prediction/delete/{id}")
    ResponseEntity<?> deletePrediction(@RequestParam Long id) {
        BaseResponse response = predictionsService.DeletePrediction(id);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }












    @PostMapping(value = "/games/game/add")
    ResponseEntity<?> addGame(@RequestBody NewGameAndPrediction newGameAndPrediction) {
        BaseResponse response = gamesService.addGame(newGameAndPrediction);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/games/game/update")
    ResponseEntity<?> updateGame(@RequestBody Games games) {
        BaseResponse response = gamesService.UpdateGames(games);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping(value = "/games/game/create") //convert the prediction into a game
    ResponseEntity<?> createGame(@RequestParam Long PredictionID, Long SetID) {
        BaseResponse response = gamesService.CreateGameFromPrediction(PredictionID, SetID);
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/games/game/get_by_userid/{id}")
        ResponseEntity<?> getUserGames(@RequestParam Long UserID, @RequestParam() @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE) Date matchDate) {
            BaseResponse response = null;
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

//    @GetMapping(value = "/games/game/get_by_date")
//    ResponseEntity<?> getUserGames(@RequestParam Long UserID, @RequestParam Date MatchDate) {
//        BaseResponse response = gamesService.GetAllGamesByDate()
//        if (response.getStatusCode() == 200) {
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//        }
//    }
    @GetMapping(value = "/games/game/get_settings")
    ResponseEntity<?> getGamesSettings() {
        BaseResponse response = null;
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }









    @PostMapping(value = "/games/comment/create")
    ResponseEntity<?> addComment(@RequestParam Long UserID, Long GameID, String comments) {
        BaseResponse response = null;
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/games/comment/get_game_comments")
    ResponseEntity<?> getComments(@RequestParam Long GameID) {
        BaseResponse response = null;
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }










    @PostMapping(value = "/games/vote/create")
    ResponseEntity<?> addGameVote(@RequestParam Long UserID, Long GameID, Long UserVote, Long HomeVote, Long AwayVote,
                                  Long DrawVote) {
        BaseResponse response = null;
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/games/vote/get_game_votes")
    ResponseEntity<?> getGameVotes(@RequestParam Long UserID, @RequestParam Long GameID) {
        BaseResponse response = null;
        if (response.getStatusCode() == 200) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }






}