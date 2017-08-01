<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <asset:javascript src="application.js"/>
    <asset:stylesheet src="application.css"/>
    <asset:stylesheet src="bnp.css"/>
    <g:javascript library="jquery"></g:javascript>
</head>
<body>

<div class="container-fluid text-center">

    <div class="page-header">
        <h1>Welcome to Book & Play <small>${user.firstName}&nbsp;${user.lastName}</small></h1>
    </div>
        <sec:ifAnyGranted roles='ROLE_USER'>
            <a class="btn btn-primary noline" href="/booking/create">Book Court</a>
        </sec:ifAnyGranted>
        <a class="btn btn-success noline" href="/booking">View Bookings</a>
        <g:if test="${bookings}">
            <h3>Your Last booking:</h3>
            ${bookings.last().dateOfBooking}
        </g:if>




</div>
</body>
</html>



