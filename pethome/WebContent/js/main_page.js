// JavaScript Document
var i=0;
var timer;
$(function(){
	/*显示第一张图片，其他图片隐藏*/
	$(".img").eq(0).show().siblings().hide();
	//showTime();
	show();
	$(".button").hover(function(){
		i=$(this).index();
		show();
		clearInterval(timer);
		},function(){
			//showTime();
			});
		prevClick();
		nextClick();
	});
	
function prevClick(){
	/*点击上一页，先清除定时滚动，进行判断，如果是第一张的话就让i=6，调到最后一张*/
	$("#prev").click(function(){
		clearInterval(timer);
		if(i==0){
			i=6;
		}
		i--;
		show();//进行图片切换
		//showTime();
		});
	}
function nextClick(){
		/*点击下一页，先清除定时滚动，进行判断，如果是第一张的话就让i=6，调到最后一张*/
      $("#next").click(function(){
		  clearInterval(timer);
		  if(i==6){
			  i=-1;
		  }
		  i++;
		 show();
		
		 // showTime();
		  });
	}	
	
	
function showTime(){
	timer=setInterval(function(){
		i++;
	if(i==6){
	   i=0;
	  }
	},4000);	
	  show();
	}
function show(){
/*	切换图片时候的动画效果*/
	$(".img").eq(i).fadeIn(300).siblings().fadeOut(300);
	$(".button").eq(i).addClass("bg").siblings().removeClass("bg");
	}