/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ClayResultsBar} from '@clayui/management-toolbar';
import React, {useContext} from 'react';

import lang from '../../utils/lang.es';
import Button from '../button/Button.es';
import SearchContext from './SearchContext.es';

export default ({isLoading, totalCount}) => {
	const [{keywords}, dispatch] = useContext(SearchContext);

	if (keywords && !isLoading) {
		return (
			<ClayResultsBar>
				<ClayResultsBar.Item expand>
					<span className="component-text text-truncate-inline">
						<span className="text-truncate">
							{lang.sub(Liferay.Language.get('x-results-for-x'), [
								totalCount,
								keywords,
							])}
						</span>
					</span>
				</ClayResultsBar.Item>
				<ClayResultsBar.Item>
					<Button
						className="component-link tbar-link"
						displayType="unstyled"
						onClick={() =>
							dispatch({
								keywords: '',
								type: 'SEARCH',
							})
						}
					>
						Clear
					</Button>
				</ClayResultsBar.Item>
			</ClayResultsBar>
		);
	}

	return <></>;
};
