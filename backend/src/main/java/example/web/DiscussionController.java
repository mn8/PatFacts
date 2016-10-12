//package example.web;
//
//import example.model.Discussion;
//import example.model.DiscussionComment;
//import example.service.DiscussionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("discussions")
//class DiscussionController {
//
//    @Autowired
//    DiscussionService discussionService;
//
///*    
//     * Basic REST methods for interacting with a discussion.  Does not support batch-update or or delete-all.
////     
//*/
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public List<Discussion> getAllDiscussions() {
//        return discussionService.getAllDiscussions();
//    }
//
//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public Discussion createDiscussion(@RequestBody Discussion discussion) {
//        return discussionService.createDiscussion(discussion);
//    }
//
//    @RequestMapping(value = "{discussionId}", method = RequestMethod.GET)
//    public Discussion getDiscussion(@PathVariable Long discussionId) {
//        return discussionService.getDiscussion(discussionId);
//    }
//
//    @RequestMapping(value = "{discussionId}", method = RequestMethod.PUT)
//    public Discussion editDiscussion(@PathVariable Long discussionId, @RequestBody Discussion discussion) {
//        return discussionService.editDiscussion(discussionId, discussion);
//    }
//
//    @RequestMapping(value = "{discussionId}", method = RequestMethod.DELETE)
//    public void deleteDiscussion(@PathVariable Long discussionId) {
//        discussionService.deleteDiscussion(discussionId);
//    }
//
//    
///*     * Basic REST methods for commenting on an existing discussion.  I opted to put these in the same file because
//     * a DiscussionComment only makes sense in the context of a Discussion, and I like the idea of fewer files.
//     * This will only work well if everyone follows the convention of putting comment-related code underneath this
//     * comment to maintain readability.
//     */
//
//    @RequestMapping(value = "{discussionId}/comments/", method = RequestMethod.GET)
//    public List<DiscussionComment> getDiscussionComments(@PathVariable Long discussionId) {
//        return discussionService.getDiscussionComments(discussionId);
//    }
//
//    @RequestMapping(value = "{discussionId}/comments/", method = RequestMethod.POST)
//    public DiscussionComment createDiscussionComment(@PathVariable Long discussionId, @RequestBody DiscussionComment discussionComment) {
//        return discussionService.createDiscussionComment(discussionId, discussionComment);
//    }
//
//    @RequestMapping(value = "{discussionId}/comments/{commentId}", method = RequestMethod.GET)
//    public DiscussionComment getDiscussionComment(@PathVariable Long discussionId, @PathVariable Long commentId) {
//        return discussionService.getDiscussionComment(discussionId, commentId);
//    }
//
//    @RequestMapping(value = "{discussionId}/comments/{commentId}", method = RequestMethod.PUT)
//    public DiscussionComment editDiscussionComment(@PathVariable Long discussionId, @PathVariable Long commentId, @RequestBody DiscussionComment discussionComment) {
//        return discussionService.editDiscussionComment(discussionId, commentId, discussionComment);
//    }
//
//    @RequestMapping(value = "{discussionId}/comments/{commentId}", method = RequestMethod.DELETE)
//    public void deleteDiscussionComment(@PathVariable Long discussionId, @PathVariable Long commentId) {
//        discussionService.deleteDiscussionComment(discussionId, commentId);
//    }
//
//}