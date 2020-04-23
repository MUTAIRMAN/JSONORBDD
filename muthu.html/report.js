$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Features/JSONReaderTest.feature");
formatter.feature({
  "line": 1,
  "name": "JSONReaderTest",
  "description": "",
  "id": "jsonreadertest",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "SampleTest",
  "description": "",
  "id": "jsonreadertest;sampletest",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 2,
      "name": "@dimple"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I test ReadJSON",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinition.TestJson()"
});
