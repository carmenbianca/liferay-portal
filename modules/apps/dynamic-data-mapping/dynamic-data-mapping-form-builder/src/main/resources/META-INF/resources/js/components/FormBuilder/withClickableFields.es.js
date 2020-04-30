/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {EventHandler} from 'metal-events';
import Component from 'metal-jsx';

import formBuilderProps from './props.es';

const withClickableFields = ChildComponent => {
	class ClickableFields extends Component {
		attached() {
			this._eventHandler = new EventHandler();

			this._eventHandler.add(
				this.delegate(
					'click',
					'.ddm-field-container',
					this._handleFieldClicked.bind(this)
				)
			);
		}

		disposed() {
			this._eventHandler.removeAllListeners();
		}

		render() {
			return <ChildComponent {...this.props} />;
		}

		_handleFieldClicked(event) {
			const {delegateTarget} = event;
			const {dispatch} = this.context;
			const {fieldName} = delegateTarget.dataset;

			event.stopPropagation();

			dispatch('fieldClicked', {fieldName});
		}
	}

	ClickableFields.PROPS = {
		...formBuilderProps,
	};

	return ClickableFields;
};

export default withClickableFields;
