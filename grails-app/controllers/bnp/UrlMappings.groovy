package bnp

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller:"main",action:"index")
        "/booking"(resources:"booking")
        "/payment"(resources:"payment")
        "/booking/index"(controller:"booking",action:"index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
