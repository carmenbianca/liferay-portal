/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

import {Component} from '../PluginContext.es';
import RulesSidebar from './components/RulesSidebar.es';

/**
 * Entry-point for "RulesSidebar" (sidebar panel) functionality.
 */
export default class {
	constructor({app, panel}) {
		this.Component = Component(app);
		this.title = panel.label;
	}

	renderSidebar() {
		const {Component} = this;

		return (
			<Component>
				<RulesSidebar title={this.title} />
			</Component>
		);
	}
}
