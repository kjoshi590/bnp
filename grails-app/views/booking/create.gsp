<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <asset:javascript src="application.js"/>
        <asset:stylesheet src="application.css"/>
        <asset:stylesheet src="bnp.css"/>
        <g:set var="entityName" value="${message(code: 'booking.label', default: 'Booking')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
        <g:javascript library="jquery"></g:javascript>
    </head>
    <body>
        <a href="#create-booking" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-booking" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.booking}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.booking}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.booking}" method="POST" class="">
                <fieldset class="form">

                    <f:field property="court" bean="booking"></f:field><br>
                    <f:field property="dateOfBooking" bean="booking"></f:field><br>
                    <h4>Payment options:</h4><br>
                    <g:hiddenField name="payment_type" id="payment_type" value="Netbanking"></g:hiddenField>
                    <div class="panel-group payment-panel" id="accordion" role="tablist" aria-multiselectable="true">
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingOne">
                                <h4 class="panel-title">
                                    <a role="button" data-toggle="collapse"   data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                        NetBanking (15% Off)
                                    </a>
                                </h4>
                            </div>

                            <div id="collapseOne" class="panel-collapse collapse in"  data-payment="Netbanking" role="tabpanel" aria-labelledby="headingOne">
                                <div class="panel-body">
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label">Bank Name</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="payment_info.bank_name"   placeholder="ABCD Bank">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-sm-4 control-label">Account Number</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="payment_info.acc_number"   placeholder="XXXXXX">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-sm-4 control-label">IFSC Code</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="payment_info.ifsc_code" >
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingTwo">
                                <h4 class="panel-title">
                                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                        Card Payment (20% Off)
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseTwo" class="panel-collapse collapse"  data-payment="Card" role="tabpanel" aria-labelledby="headingTwo">
                                <div class="panel-body">
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label">Issueing Bank Name</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="payment_info.issueing_bank_name"   placeholder="ABCD Bank">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-sm-4 control-label">Card Number</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="payment_info.card_number"   placeholder="XXXXXX">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-sm-4 control-label">CVV</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="payment_info.card_cvv" placeholder="XXX" >
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingThree">
                                <h4 class="panel-title">
                                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                        Wallet Payment (25% Off)
                                    </a>
                                </h4>
                            </div>
                            <div id="collapseThree" class="panel-collapse collapse"  data-payment="Wallet" role="tabpanel" aria-labelledby="headingThree">
                                <div class="panel-body">
                                    <div class="form-group">
                                        <label class="col-sm-4 control-label"> Wallet Name</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="payment_info.wallet_name"   placeholder="XXXX">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-sm-4 control-label">User Id</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="payment_info.wallet_id"   placeholder="XXXXXX">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-sm-4 control-label">Wallet PIN</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="payment_info.wallet_pin" placeholder="XXXX">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </fieldset>

                <div class="col-sm-8 text-center">
                    <g:submitButton name="create" class="save save-button btn btn-primary" value="Create Booking" />
                </div>
            </g:form>
        </div>
    <g:javascript>
        $(function() {

            $('.collapse').on('shown.bs.collapse', function () {
                // do something…
                $('#payment_type').val($(this).data('payment'));
            })
            $("form").submit(function()
            {
                $( ".collapse" ).each(function() {
                    if ($(this).css('display') == 'none')
                    {
                        $(this).remove();
                    }

                });

                return true; // ensure form still submits
            });
        });
    </g:javascript>

    </body>
</html>


