/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

import {Component} from '../../core/AppContext';
import MappingSidebar from './components/MappingSidebar';

/**
 * Entry-point for "Mapping" (sidebar pane) functionality.
 */
export default class Mapping {
	constructor({app, panel}) {
		this.Component = Component(app);
		this.title = panel.label;
	}

	renderSidebar() {
		const {Component} = this;

		return (
			<Component>
				<MappingSidebar title={this.title} />
			</Component>
		);
	}
}
