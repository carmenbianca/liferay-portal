/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import Component from 'metal-component';
import dom from 'metal-dom';
import {EventHandler} from 'metal-events';
import {Config} from 'metal-state';

class PagesTreeEventHandler extends Component {
	attached() {
		this._eventHandler = new EventHandler();

		this._eventHandler.add(
			dom.delegate(
				document,
				'click',
				'.layout-action',
				this._handleLayoutActionClick.bind(this)
			)
		);
	}

	disposed() {
		this._eventHandler.removeAllListeners();
	}

	addChildPage(plid) {
		const url = `${this.addLayoutURL}&${this.portletNamescape}selPlid=${plid}`;

		Liferay.Util.navigate(url);
	}

	configure(plid) {
		const url = `${this.configureLayoutURL}&${this.portletNamescape}selPlid=${plid}`;

		Liferay.Util.navigate(url);
	}

	_handleLayoutActionClick(event) {
		const {delegateTarget} = event;

		const {action, plid} = delegateTarget.dataset;

		this[action](plid);
	}
}

PagesTreeEventHandler.STATE = {
	addLayoutURL: Config.string(),
	configureLayoutURL: Config.string(),
	deleteLayoutURL: Config.string(),
	duplicateLayoutURL: Config.string(),
	editLayoutURL: Config.string(),
	portletNamescape: Config.string(),
};

export default PagesTreeEventHandler;
