/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import Component from 'metal-component';
import Soy from 'metal-soy';

import templates from './Tabs.soy';

class Tabs extends Component {
	_handleItemClicked({delegateTarget: {dataset}}) {
		const {dispatch} = this.context;
		const {pageIndex} = dataset;

		dispatch('paginationItemClicked', {
			pageIndex: Number(pageIndex),
		});
	}
}

Soy.register(Tabs, templates);

export default Tabs;
