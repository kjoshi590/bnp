<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'booking.label', default: 'Booking')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-booking" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-booking" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                    <tr>

                        <g:sortableColumn property="id" title="Id"/>

                        <g:sortableColumn property="dateOfBooking" title="Date"/>

                        <g:sortableColumn property="payment.amount" title="Amount Paid"/>

                        <g:sortableColumn property="court" title="Court"/>

                    </tr>
                    </thead>
                    <tbody>
                    <g:each in="${bookingList}" status="i" var="booking">
                        <tr >

                            <td><g:link action="show" id="${booking.id}">${fieldValue(bean:booking, field:'id')}</g:link></td>

                            <td>${fieldValue(bean:booking, field:'dateOfBooking')}</td>

                            <td>${fieldValue(bean:booking, field:'payment.amount')}</td>

                            <td>${fieldValue(bean:booking, field:'court')}</td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>


            <div class="pagination">
                <g:paginate total="${bookingCount ?: 0}" />
            </div>
        </div>
    </body>
</html>