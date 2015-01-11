package com.narfdre.filters

import com.twitter.finagle.{Service, SimpleFilter}
import com.twitter.finagle.http.{Request => FinagleRequest}
import com.twitter.finagle.http.{Response => FinagleResponse}
import com.twitter.util.Future

/**
 * Created by andre on 1/10/15.
 */
class SecurityFilter extends SimpleFilter[FinagleRequest, FinagleResponse]{
  override def apply(
      request: FinagleRequest,
      service: Service[FinagleRequest, FinagleResponse]
  ): Future[FinagleResponse] = {
    service(request) map { response =>
      if(request.path.startsWith("/api")){
        //Perform some logic that checks for auth token and what not
      }
      response
    }
  }
}
