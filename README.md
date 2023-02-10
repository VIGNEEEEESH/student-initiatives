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
<p>"clubId" : int</p>
<p>"clubName" : string</p>
<p>"presidentName" : string</p>
<p>"vicePresidentName" : string</p>
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
</td>
<td>Nothing</td>
<td>Adds a new user</td>
</tr>
<tr>
<td>/api/{email}</td>
<td>DELETE</td>
<td>The {email} path variable</td>
<td>Nothing</td>
<td>Deletes the user with that email AND the club associated with that user</td>
</table>
