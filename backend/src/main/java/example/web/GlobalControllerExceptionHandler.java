//package example.web;
//
//import example.exception.CommentNotFoundException;
//import example.exception.DiscussionNotFoundException;
//import example.exception.NotImplementedYetException;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
///**
// * Created by jdifebo on 5/4/2016.
// */
//
//@ControllerAdvice
//class GlobalControllerExceptionHandler {
//
//    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
//    @ExceptionHandler(DiscussionNotFoundException.class)
//    public @ResponseBody String discussionNotFound() {
//        return "Your request seems valid, but we couldn't find a matching discussion";
//    }
//
//    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
//    @ExceptionHandler(CommentNotFoundException.class)
//    public @ResponseBody String commentNotFound() {
//        return "Your request seems valid, but we couldn't find a matching comment";
//    }
//
//    // The controller supports the method, but it's calling something broken in the service layer
//    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)  // 500
//    @ExceptionHandler(NotImplementedYetException.class)
//    public @ResponseBody String notImplementedYetOperation() {
//        return "Still working on that one!";
//    }
//}