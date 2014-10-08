package com.webbfontaine.hubbub

class UserController {

    static scaffold = true

    def search() {}

    def results(String loginId) {
        def users = User.where {
            loginId =~ "%${loginId}%"
        }.list()
        return [users: users,
                term: params.loginId,
                totalUsers: User.count()]
    }

    def advSearch() {}

    def advResults() {
        def profiles = Profile.where {
           ilike fullName == params.fullName?.value
        }.list()


//        def profileProps = Profile.metaClass.properties*.name
//        def profiles = Profile.withCriteria {
//            "${params.queryType}" {
//
//                params.each { field, value ->
//
//                    if (profileProps.grep(field) && value) {
//                        ilike(field, "%${value}%")
//                    }
//                }
//
//            }
//
//        }
        [profiles: profiles]

    }
}
