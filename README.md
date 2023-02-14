# How to Run the Backend

### Requiremnts

- JDK 17+
- Any IDE with Java EE support
- MySQL installation
- Internet connection (first time build only)

### Steps

1. clone the project
2. In `/student-initiatives-backend/src/main/resources/application.properties` ,change the credentials to your MySQL details
3. Run the Schema generator.sql file to generate the database
4. Run the `StudentInitiativesBackendApplication.java` at the root of `com.woxsen.studentinitiatives` package.
5. The application will run on localhost:8080 by default and all APIs can be accessed from there.

# API Description

## Authentication-related

<table>
<tr>
<th>URL</th>
<th>Method</th>
<th>Consumes</th>
<th>Produces</th>
<th>Description</th>
</tr>
<tr>
<td>/api/user/{email}/{password}</td>
<td>GET</td>
<td>The {email} and {password} path variables</td>
<td>JSON.
<p>Format - </p>
<p>{</p>
<p>"clubId" : number</p>
<p>"clubName" : string</p>
<p>"presidentName" : string</p>
<p>"vicePresidentName" : string</p><tr>
<th>URL</th>
<th>Method</th>
<th>Consumes</th>
<th>Produces</th>
<th>Description</th>
</tr>
<p>}</p> 
</td>
<td>Provided that the email-password combination is correct, returns a json containing information on the club the email is linked to.</td>
</tr>
<tr>
<td>/api/user/</td>
<td>POST</p>
<td>JSON.
<p>Format - </p>
<p>{</p>
<p>"email" : string</p>
<p>"password" : string</p>
<p>}</p>
</td><tr>
<th>URL</th>
<th>Method</th>
<th>Consumes</th>
<th>Produces</th>
<th>Description</th>
</tr>
<td>JSON with HTTP code</td>
<td>Adds a new user</td>
</tr>
<tr>
<td>/api/user/</td>
<td>DELETE</td>
<td><p>JSON Format - </p>
<p>{</p>
<p>"email":string,</p>
<p>"password":string</p>
<p>}</p>
</td>
<td>JSON with HTTP code</td>
<td>Deletes the user with those credentials AND the club associated with that user</td>
</tr><tr>
<th>URL</th>
<th>Method</th>
<th>Consumes</th>
<th>Produces</th>
<th>Description</th>
</tr>
## School-related

<table>
<tr>
<th>URL</th>
<th>Method</th>
<th>Consumes</th>
<th>Produces</th>
<th>Description</th>
</tr>
<tr>
<td>/api/school/</td>
<td>GET</td>
<td>Nothing</td>
<td><p>JSON</p>
<p>Format - List of schools </p></td>
<td>Gets the list of all schools available in the DB</td>
</tr>
<tr>
<td>/api/school/{schoolId}/clubs</td><tr>
<th>URL</th>
<th>Method</th>
<th>Consumes</th>
<th>Produces</th>
<th>Description</th>
</tr>
<td>GET</td>
<td>The {schoolId} path variable</td>
<td><p>JSON Format - </p>
<p>Club[]</td>
<td>Get the list of all the clubs associated from that schoolId</td>
</tr>
<tr>
<td>/api/school/{schoolId}</td>
<td>GET</td>
<td>The {schoolId} path variable</td>
<td><p>JSON Format - </p>
<p>{</p>
<p>"schoolId": number,</p>
<p>"schoolName" : string</p>
<p>}</p>
</td>
<td>Gets info on the specific school</td>
</tr>
<tr>
<td>/api/school/</td>
<td>POST</td>
<td><p>JSON Format - </p>
<p>{ "schoolName" : string }</p>
</td>
<td>String or JSON with HTTP response code</td>
<td>Add a school to the database</td>
</tr>
<tr>
<td>/api/school/{schoolId}</td>
<td>DELETE</td>
<td>The {schoolId} path variable</td>
<td>String or JSON with HTTP response code</td>
<td>Delete a school from DB by it's ID</td>
</tr>
</table>

## Club-related

<table>
<tr>
<th>URL</th>
<th>Method</th>
<th>Consumes</th>
<th>Produces</th>
<th>Description</th>
</tr>
<tr>
<td>/api/club/</td>
<td>GET</td>
<td>Nothing</td>
<td>JSON Format - Club[]</td>
<td>Returns list of all clubs</td>
</tr>
<tr>
<td>/api/club/</td>
<td>POST</td>
<td>JSON Format - <tr>
<th>URL</th>
<th>Method</th>
<th>Consumes</th>
<th>Produces</th>
<th>Description</th>
</tr>
<p>{</p>
<p>"clubName": string, </p>
<p>"presidentName": string,</p>
<p>"vicePresidentName": string,</p>
<p>"mission":"To hire more",</p>
<p>"vision": string,</p>
<p>"email": string,</p>
<p>"schoolId": number</p>
<p>}</p>
</td>
<td>JSON format - { "clubId": number }</td>
<td>Adds the given club to the DB and returns the generated clubId. The email and school with given schoolId must already exist in the DB.
</tr>
<tr>
<td>/api/club/{clubId}</td>
<td>GET</td>
<td>The path variable {clubId}</td>
<td>JSON Format - 
<p>{</p>
<P>"clubId": number, </p>
<p>"clubName": string, </p>
<p>"presidentName": string,</p>
<p>"vicePresidentName": string,</p>
<p>"mission":"To hire more",</p>
<p>"vision": string,</p>
<p>}</p>
</td>
<td>Gets info on the specific club associated with the given clubId</td>
</tr>
<tr>
<td>/api/club/{clubId}</td>
<td>DELETE</td>
<td>The path variable {clubId}</td>
<td>JSON with HTTP code</td>
<td>Deletes club with the given clubId</td>
</tr>
<tr>
<td>/api/club/{clubId}/image/{type}</td>
<td>GET</td>
<td>The {clubId} and {type} path variables. Type can only be "logos", "president" or "vice-president"</td>
<td>A JPEG,JPG or PNG image</td>
<td>Returns an image of the club associated with the given clubId. Image is of the president, vice-president or the club logo.</td>
</tr>
<tr>
<td>/api/club/{clubId}/image/{type}</td>
<td>POST</td>
<td>The {clubId} and {type} path variables</td>
<td>A string or JSON(if error occurs) with HTTP code</td>
<td>Adds the club logo, president or vice-president of the given club.</td>
</table>
