$(document).ready(function () {
  $('.nav > ul > li').mouseover(function () {
    $(this).find('.submenu').stop().slideDown(400)
  })

  $('.nav > ul > li').mouseout(function () {
    $(this).find('.submenu').stop().slideUp(400)
  })
})
