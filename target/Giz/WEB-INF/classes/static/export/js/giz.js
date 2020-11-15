
var Module = (function () {


    var init = function () {

        var align_checkbox = function (e) {
            var $this = $(this),
                offset = $this.offset(),
                checkid = $this.attr('for'),
                $check_target = $('#' + checkid);

            $check_target.css('top', offset.top);
        };

        $(document).on('mousedown.init', 'label[for*="check"]', align_checkbox);

        // custom select
        var collapse_select = function (e) {

        };

        $(document).on('click', function (e) {
            var $parent = $(e.target).parents(),
                $check_toggle = $('.custom-select').find('.check-toggle:checked');

            if (!$parent.hasClass('form-row')) {
                $check_toggle.prop('checked', false);
            } else {
                $parent.siblings().find('.check-toggle:checked').prop('checked', false);
            }
        });
    }

    return {
        init: init
    }
})();

$(window).on('load', Module.init);
window.addEventListener('load', Module.init);
