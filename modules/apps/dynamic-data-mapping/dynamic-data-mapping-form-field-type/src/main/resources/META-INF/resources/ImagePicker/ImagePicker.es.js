/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import '../FieldBase/FieldBase.es';

import './ImagePickerAdapter.soy';

import './ImagePickerRegister.soy';

import './ReactImagePickerAdapter.es';

import Component from 'metal-component';
import Soy from 'metal-soy';
import {Config} from 'metal-state';

import templates from './ImagePicker.soy';

class ImagePicker extends Component {
	dispatchEvent(event, name, value) {
		this.emit(name, {
			fieldInstance: this,
			originalEvent: event,
			value,
		});
	}

	_handleOnDispatch(event) {
		switch (event.type) {
			case 'value':
				this.dispatchEvent(event, 'fieldEdited', event.payload);
				break;
			default:
				console.error(new TypeError(`There is no type ${event.type}`));
				break;
		}
	}
}

ImagePicker.STATE = {
	/**
	 * @default undefined
	 * @instance
	 * @memberof ImagePicker
	 * @type {?(string|undefined)}
	 */

	errorMessage: Config.string(),

	/**
	 * @default false
	 * @instance
	 * @memberof ImagePicker
	 * @type {?bool}
	 */

	evaluable: Config.bool().value(false),

	/**
	 * @default undefined
	 * @instance
	 * @memberof ImagePicker
	 * @type {?(string|undefined)}
	 */

	fieldName: Config.string(),

	/**
	 * @default undefined
	 * @instance
	 * @memberof ImagePicker
	 * @type {?(string|undefined)}
	 */

	label: Config.string(),

	/**
	 * @default undefined
	 * @instance
	 * @memberof ImagePicker
	 * @type {?(string|undefined)}
	 */

	name: Config.string().required(),

	/**
	 * @default '000000'
	 * @instance
	 * @memberof ImagePicker
	 * @type {?(string|undefined)}
	 */

	predefinedValue: Config.string(),

	/**
	 * @default false
	 * @instance
	 * @memberof ImagePicker
	 * @type {?bool}
	 */

	readOnly: Config.bool().value(false),

	/**
	 * @default undefined
	 * @instance
	 * @memberof FieldBase
	 * @type {?(bool|undefined)}
	 */

	repeatable: Config.bool().value(false),

	/**
	 * @default false
	 * @instance
	 * @memberof ImagePicker
	 * @type {?(bool|undefined)}
	 */

	required: Config.bool().value(false),

	/**
	 * @default true
	 * @instance
	 * @memberof ImagePicker
	 * @type {?(bool|undefined)}
	 */

	showLabel: Config.bool().value(true),

	/**
	 * @default undefined
	 * @instance
	 * @memberof ImagePicker
	 * @type {?(string|undefined)}
	 */

	spritemap: Config.string(),

	/**
	 * @default undefined
	 * @instance
	 * @memberof ImagePicker
	 * @type {?(string|undefined)}
	 */

	tip: Config.string(),

	/**
	 * @default undefined
	 * @instance
	 * @memberof ImagePicker
	 * @type {?(string|undefined)}
	 */

	value: Config.string(),
};

Soy.register(ImagePicker, templates);
export {ImagePicker};
export default ImagePicker;
