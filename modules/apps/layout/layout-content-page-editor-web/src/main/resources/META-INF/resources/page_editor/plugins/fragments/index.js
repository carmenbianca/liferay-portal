/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import React from 'react';

import {Component} from '../../core/AppContext';
import FragmentsSidebar from './components/FragmentsSidebar';
/**
 * Entry-point for "Fragments" (sidebar pane) functionality.
 */
export default class Fragments {
	constructor({app, panel}) {
		this.Component = Component(app);
		this.title = panel.label;
	}

	renderSidebar() {
		const {Component} = this;

		return (
			<Component>
				<FragmentsSidebar title={this.title} />
			</Component>
		);
	}
}
