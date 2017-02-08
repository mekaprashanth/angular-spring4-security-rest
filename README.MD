OAuth2
 
1. For Authorization Code authentication use below url (HTTP GET)
 http://localhost:8081/mvcsample/rest/oauth/authorize?client_id=web_app&response_type=code&scope=read&redirect_uri=http://localhost:8081/mvcsample/index.html
 
You will be displayed with login page - use below credentials
 usernam: password
 password: password
 
You will be redirected to confirm access endpoint
 once you authorize the acces you will be reditected to the actual resource which you requested in the initial url - redirect_uri=http://localhost:8081/mvcsample/index.html with AUTHORIZATION_CODE in the parameter
 
 using this code access_token can be requested
 
Application will again request for access token using authorization code like below
 http://localhost:8081/mvcsample/rest/oauth/token?client_id=web_app&grant_type=authorization_code&code=AUTHORIZATION_CODE&redirect_uri=http://localhost:8081/mvcsample/index.html

You will be provided with access token like below
 {
  "access_token": "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX25hbWUiOiJwcmFzaCIsImFsbGlhY2VJZCI6InByYXNoYW50aCIsInNjb3BlIjpbIndyaXRlIiwiZm9vIiwicmVhZCJdLCJleHAiOjE0ODY1ODQxNDUsImF1dGhvcml0aWVzIjpbIlVTRVIiLCJDRU8iLCJBRE1JTiJdLCJqdGkiOiI4ZTk0NmE2ZC1iNzY2LTQ3Y2QtYmY0Yi1lOTZmZTIzMjkzMjIiLCJjbGllbnRfaWQiOiJ3ZWJfYXBwIiwidXNlcm5hbWUiOiJwcmFzaCJ9.g19mwU5eDCBAzW_FmUQq7aa4QFFb6B5NUGyi7crGuVU",
  "token_type": "bearer",
  "refresh_token": "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX25hbWUiOiJwcmFzaCIsImFsbGlhY2VJZCI6InByYXNoYW50aCIsInNjb3BlIjpbIndyaXRlIiwiZm9vIiwicmVhZCJdLCJhdGkiOiI4ZTk0NmE2ZC1iNzY2LTQ3Y2QtYmY0Yi1lOTZmZTIzMjkzMjIiLCJleHAiOjE0ODkxMzI5NDUsImF1dGhvcml0aWVzIjpbIlVTRVIiLCJDRU8iLCJBRE1JTiJdLCJqdGkiOiI5NmYyZjU2Ni05ZjhlLTRjZDAtOGM2NS1mMjYyNzAzODZkMTUiLCJjbGllbnRfaWQiOiJ3ZWJfYXBwIiwidXNlcm5hbWUiOiJwcmFzaCJ9.LThpRR5dlwFazawMQXfQ9SBi7p8SxPLpp-ciNdy-Qw4",
  "expires_in": 43199,
  "scope": "write foo read",
  "username": "prash",
  "alliaceId": "prashanth",
  "jti": "8e946a6d-b766-47cd-bf4b-e96fe2329322"
}
 
 
2. For password authentication use below url (HTTP POST) - use postman
 http://localhost:8081/mvcsample/rest/oauth/token?client_id=web_app&grant_type=password&username=prash&password=prash
 
 you will be provided with access_token like below

{
  "access_token": "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX25hbWUiOiJwcmFzaCIsImFsbGlhY2VJZCI6InByYXNoYW50aCIsInNjb3BlIjpbIndyaXRlIiwiZm9vIiwicmVhZCJdLCJleHAiOjE0ODY1ODQxNDUsImF1dGhvcml0aWVzIjpbIlVTRVIiLCJDRU8iLCJBRE1JTiJdLCJqdGkiOiI4ZTk0NmE2ZC1iNzY2LTQ3Y2QtYmY0Yi1lOTZmZTIzMjkzMjIiLCJjbGllbnRfaWQiOiJ3ZWJfYXBwIiwidXNlcm5hbWUiOiJwcmFzaCJ9.g19mwU5eDCBAzW_FmUQq7aa4QFFb6B5NUGyi7crGuVU",
  "token_type": "bearer",
  "refresh_token": "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX25hbWUiOiJwcmFzaCIsImFsbGlhY2VJZCI6InByYXNoYW50aCIsInNjb3BlIjpbIndyaXRlIiwiZm9vIiwicmVhZCJdLCJhdGkiOiI4ZTk0NmE2ZC1iNzY2LTQ3Y2QtYmY0Yi1lOTZmZTIzMjkzMjIiLCJleHAiOjE0ODkxMzI5NDUsImF1dGhvcml0aWVzIjpbIlVTRVIiLCJDRU8iLCJBRE1JTiJdLCJqdGkiOiI5NmYyZjU2Ni05ZjhlLTRjZDAtOGM2NS1mMjYyNzAzODZkMTUiLCJjbGllbnRfaWQiOiJ3ZWJfYXBwIiwidXNlcm5hbWUiOiJwcmFzaCJ9.LThpRR5dlwFazawMQXfQ9SBi7p8SxPLpp-ciNdy-Qw4",
  "expires_in": 43199,
  "scope": "write foo read",
  "username": "prash",
  "alliaceId": "prashanth",
  "jti": "8e946a6d-b766-47cd-bf4b-e96fe2329322"
}