<div class="container">
    <h1>Welcome to BnP: ${user.firstName}</h1>

    <sec:ifAnyGranted roles='ROLE_USER'>
        <a class="btn btn-primary" href="/booking/create">Book Court</a>
    </sec:ifAnyGranted>
    <a class="btn btn-success" href="/booking">View Bookings</a>
    <g:if test="${bookings}">
        <h3>Your Latest booking:</h3>
        ${bookings.last().dateOfBooking}
    </g:if>
</div>



