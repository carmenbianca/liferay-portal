/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import 'dynamic-data-mapping-form-field-type';
import Component from 'metal-component';
import Soy from 'metal-soy';
import {Config} from 'metal-state';

import './JournalArticleSelectorAdapter.soy';

import './JournalArticleSelectorRegister.soy';

import './ReactJournalArticleSelectorAdapter';
import templates from './JournalArticleSelector.soy';

class JournalArticleSelector extends Component {
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
			case 'blur':
				this.dispatchEvent(
					event.payload,
					'fieldBlurred',
					event.payload.target.value
				);
				break;
			case 'focus':
				this.dispatchEvent(
					event.payload,
					'fieldFocused',
					event.payload.target.value
				);
				break;
			default:
				console.error(new TypeError(`There is no type ${event.type}`));
				break;
		}
	}
}

JournalArticleSelector.STATE = {
	/**
	 * @default undefined
	 * @instance
	 * @memberof JournalArticleSelector
	 * @type {?(string|undefined)}
	 */

	errorMessage: Config.string(),

	/**
	 * @default false
	 * @instance
	 * @memberof JournalArticleSelector
	 * @type {?bool}
	 */

	evaluable: Config.bool().value(false),

	/**
	 * @default undefined
	 * @instance
	 * @memberof JournalArticleSelector
	 * @type {?(string|undefined)}
	 */

	fieldName: Config.string(),

	/**
	 * @default undefined
	 * @instance
	 * @memberof JournalArticleSelector
	 * @type {?(string|undefined)}
	 */

	label: Config.string(),

	/**
	 * @default undefined
	 * @instance
	 * @memberof JournalArticleSelector
	 * @type {?(string|undefined)}
	 */

	name: Config.string().required(),

	/**
	 * @default '000000'
	 * @instance
	 * @memberof JournalArticleSelector
	 * @type {?(string|undefined)}
	 */

	predefinedValue: Config.string().value('000000'),

	/**
	 * @default false
	 * @instance
	 * @memberof JournalArticleSelector
	 * @type {?bool}
	 */

	readOnly: Config.bool().value(false),

	/**
	 * @default undefined
	 * @instance
	 * @memberof JournalArticleSelector
	 * @type {?(bool|undefined)}
	 */

	repeatable: Config.bool().value(false),

	/**
	 * @default false
	 * @instance
	 * @memberof JournalArticleSelector
	 * @type {?(bool|undefined)}
	 */

	required: Config.bool().value(false),

	/**
	 * @default true
	 * @instance
	 * @memberof JournalArticleSelector
	 * @type {?(bool|undefined)}
	 */

	showLabel: Config.bool().value(true),

	/**
	 * @default undefined
	 * @instance
	 * @memberof JournalArticleSelector
	 * @type {?(string|undefined)}
	 */

	spritemap: Config.string(),

	/**
	 * @default undefined
	 * @instance
	 * @memberof JournalArticleSelector
	 * @type {?(string|undefined)}
	 */

	tip: Config.string(),

	/**
	 * @default undefined
	 * @instance
	 * @memberof JournalArticleSelector
	 * @type {?(string|undefined)}
	 */

	value: Config.string(),
};

Soy.register(JournalArticleSelector, templates);

export {JournalArticleSelector};
export default JournalArticleSelector;
