package com.narfdre.finny

import com.twitter.finatra.Controller

/**
 * Created by andre on 1/10/15.
 */
class Index extends Controller{
  get("/"){
    req => render.static("index.html").toFuture
  }

  post("/signup"){
    req => {
       val person = new Person(req.getParam("first"), req.getParam("last"), req.getParam("username"))
      render.json(person).toFuture
    }
  }
}

class Person(first: String, last:String, user:String) {
  var firstName = first
  var lastName = last
  var username = user
}

