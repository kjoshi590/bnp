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
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
