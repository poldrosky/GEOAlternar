$(document).ready(function(){
        $(function(){
        $('#ideal_form').submit(function(e){
                e.preventDefault();
                var form = $(this);
                var post_url = form.attr('action');
                var post_data = form.serialize();
                $('#loader3', form).html('<img src="../../images/ajax-loader.gif" />       Please wait...');
                $.ajax({
                    type: 'POST',
                    url: post_url, 
                    data: post_data,
                    success: function(msg) {
                        $(form).fadeOut(800, function(){
                            form.html(msg).fadeIn().delay(2000);

                        });
                    }
                });
            });
        });
         });