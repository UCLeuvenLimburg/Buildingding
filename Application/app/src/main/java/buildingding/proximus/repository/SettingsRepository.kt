package buildingding.proximus.repository

import buildingding.proximus.model.Language
import buildingding.proximus.model.RouteDisplay
import buildingding.proximus.model.StartChoice

object SettingsRepository {
    var language: Language = Language.English
    var startChoice: StartChoice = StartChoice.List
    var routeDisplay: RouteDisplay = RouteDisplay.Text
}