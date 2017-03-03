/**
 * @license Copyright (c) 2003-2017, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
    config.removeButtons = "Save,Form,Checkbox,Radio,TextField,Textarea,Button,Select,ImageButton,HiddenField,Language" +
        ",Iframe,Flash,NewPage,Preview,Templates,CreateDiv,About,ShowBlocks,Maximize";
    //config.extraPlugins = 'imageuploader';
};
