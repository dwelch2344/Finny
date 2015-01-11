package com.narfdre.finny

import com.narfdre.filters.SecurityFilter
import com.twitter.finatra.{Controller, FinatraServer}

/**
 * Created by andre on 1/2/15.
 */
class Finny extends Controller{

  //def testGet(request: Request) = render.plain("Hello").toFuture

  get("/finny") {
    request => render.plain("Hello Finny").toFuture
  }

}

object App extends FinatraServer{
  addFilter(new SecurityFilter)
  register(new Finny)
  register(new Index)
}
