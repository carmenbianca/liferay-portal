/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

import {Component} from '../../core/AppContext';
import PageStructureSidebar from './components/PageStructureSidebar';

/**
 * Entry-point for "Page Structure" (sidebar pane) functionality.
 */
export default class PageStructure {
	static name = 'PageStructure';

	constructor({app, panel}) {
		this.Actions = app.Actions;
		this.Component = Component(app);
		this.dispatch = app.dispatch;
		this.title = panel.label;
	}

	renderSidebar() {
		const {Component} = this;

		return (
			<Component>
				<PageStructureSidebar title={this.title} />
			</Component>
		);
	}
}
