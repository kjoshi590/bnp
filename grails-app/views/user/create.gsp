<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body>
<a href="#create-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                             default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="create-user" class="content scaffold-create" role="main">
    <h1><g:message value="Create Membership"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${this.user}">
        <ul class="errors" role="alert">
            <g:eachError bean="${this.user}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                        error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form resource="${this.user}" method="POST">
        <fieldset class="form">
            <div class="form-group">
                <f:field property="firstName" bean="user" class="form-control"></f:field>
                <f:field property="lastName" bean="user" class="form-control"></f:field>
                <f:field property="email" bean="user" class="form-control"></f:field>
                <f:field property="phone" bean="user" class="form-control"></f:field>
            </div>

            <div class="form-group text-center">
                <label class="control-label">Select Location:</label>
                <g:select name="location" class="membership-selector" from="${['Mumbai', 'NewYork', 'London']}"
                          value=""
                          noSelection="['': '-Choose your Membership Location-']"/>
                <br>
                <label class="control-label">Select Membership:</label>
                <g:select name="membership_type" class="membership-selector" from="${['Lifetime', 'Annual', 'Temporary']}"
                          value=""
                              noSelection="['': '-Choose your Membership type-']"/>



            </div>

            <div class="form-group">
                <f:field bean="user" property="userAddress"/>
            </div>

            <div class="form-group">

                <f:field property="username" bean="user"></f:field>
                <f:field property="password" bean="user"></f:field>
            </div>

        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="create" class="save"
                            value="${message(code: 'default.button.create.label', default: 'Create')}"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
