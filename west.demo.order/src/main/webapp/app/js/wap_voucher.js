$(document).on("scrollstop",function(){	
	 var autoLoad = true;
	 var gslen = $(document).height() - $(".footer").height();
     if($(document).scrollTop()+$(window).height() + 300 >= gslen)
        {
            
            var page = parseInt($("#page").val());
            var pageCount = parseInt($("#pageCount").val());
            if( page < pageCount && autoLoad == true )
            {
                getFeedList(page + 1, true );
            }
        }
 });
    function getFeedList(page, append)
    {
        var allGrouponIdStr = $('#allGrouponIdStr').val();
        if ( append == true )
        {
            $('.jiazai').insertAfter('#feedList').show();
            autoLoad = false;
        }
      
        else
        {
            $('.jiazai').insertBefore('#feedList').show();
            $('#feedList').empty();
        }
        $('#over_top').hide();
        if ( allGrouponIdStr )
        {
        	var url = '../weixin/feedlist/allGrouponIdStr/' + allGrouponIdStr;
            url += '../page/' + page + '/rand/' + Math.random();
            $.getJSON(url, function(data){
                $(".jiazai").hide();
                $("#page").val(data.page.currentPage);
                $("#pageCount").val(data.page.totalPage);
                if ( append === true )
                {
                    $('#feedList').append(
                        template.render('tplFeedList', data)
                    );
                    autoLoad = true;
                }
                else
                {
                    $('#feedList').html(template.render('tplFeedList', data));
                }
                if ( data.page.currentPage >= data.page.totalPage)
                {
                    $('#over_top').show();
                }
                if ( data.page.totalPage == 0 )
                {
                    $("#no_feed").show();
                }
                else
                {
                    $("#no_feed").hide();
                }
            });
        }else{
        	$(".jiazai").hide();
        	$("#no_feed").show();
        }
    }


