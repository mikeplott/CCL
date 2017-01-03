$(document).ready(function() {
    $('form').submit(function(event) {
        event.preventDefault();
        var uName = $('input[name=name]').val();
        var pass = $('input[name=pwd]').val();
        var uEmail = $('input[name=theEmail]').val();
      $.ajax({
          url: '/signup',
          type: 'POST',
          contentType: 'application/json',
          data: JSON.stringify({
            userName:uName,
            password:pass,
            email:uEmail
            }),
          success: function(data){
            alert('You will be redirected to the homepage to login.');
            window.location.href="/index.html";
          },
          error: function() {
            console.log("Get fucked");
          }
      });
    });
});
