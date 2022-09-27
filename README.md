# Topic Validator
Validating application for Topic contents
### Features
- Validate Topic are in the logic
- Logger details
- Topic Rules can be define by the json file
- Topic data needs to be uploaded through topic.json.
- json files are loaded through java/resources
- Comments are includedd
- Logs are included
- Unit tests are included

### Assumptions
- No inner multiple rules for the description
- No conditions will be applicable for names
- Condtions are with combination of names AND descriptions (No OR conditions)
- Topc description rules are only with the length of the description. 
- 
### Configurations
- resources/topic.json - *file user can use to validate the topics*
- resources/topicrules.json - *File which pre definde rule set of the topics*
### Third-party Libraries
- jackson-databind
- Log4j
- JUnit

### Test-cases
#### # NameValidatorTest
- Test Topic-C Name Out of Scope
- Test Topic-A Name Incorrect
- Test Topic-B Name
- Test Topic-A Name

#### # DescriptionValidatorTest
- Test Topic-A Desc more than 10
- Test Topic-A Desc less than 10
- Test Topic-B Desc less than 40
- Test Topic-C Name Out of Scope
