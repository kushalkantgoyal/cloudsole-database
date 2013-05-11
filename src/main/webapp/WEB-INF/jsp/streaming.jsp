<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <meta charset="utf-8">
    <title>Salesforce Streaming</title>
    <script src="/resources/js/jquery-1.7.1.min.js"></script>
    <script src="/resources/js/json2.js"></script>
    <script src="/resources/js/cometd.js"></script>
    <script src="/resources/js/jquery.cometd.js"></script>
    <script type="text/javascript">
      (function($) {
        var cometd = $.cometd;

        $(document).ready(function() {
          function _metaHandshake(handshake) {
            if (handshake.successful === true) {
              cometd.batch(function() {
                  cometd.subscribe('/force/AccountPush', function(messages) {
                    $("#messages").append('<pre>' + JSON.stringify(messages) + '</pre>');
                  });
              });
            }
          }

          // Disconnect when the page unloads
          $(window).unload(function() {
              cometd.disconnect(true);
          });

          var cometURL = location.protocol + "//" + location.host + "/cometd";
          cometd.configure({
              url: cometURL
          });

          cometd.addListener('/meta/handshake', _metaHandshake);

          cometd.handshake();
        });
      })(jQuery);
    </script>
  </head>
  <body>

    <div id="messages">Salesforce Streaming API</div>

  </body>
</html>