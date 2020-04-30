/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button';
import React, {useContext} from 'react';

import AppContext from '../../AppContext.es';
import EmptyState from '../empty-state/EmptyState.es';
import RuleItem from './RuleItem.es';

export default ({keywords, toggleRulesEditorVisibility}) => {
	const [
		{
			dataLayout: {dataRules},
		},
	] = useContext(AppContext);

	const filtereDataRules = dataRules
		.map((rule, index) => ({
			...rule,
			name: `Rule ${index}`,
		}))
		.filter(({name}) => new RegExp(keywords, 'ig').test(name));

	return (
		<>
			{filtereDataRules.length === 0 ? (
				<EmptyState
					emptyState={{
						button: () => (
							<ClayButton
								displayType="secondary"
								onClick={() => toggleRulesEditorVisibility()}
							>
								{Liferay.Language.get('add-rule')}
							</ClayButton>
						),
						description: Liferay.Language.get(
							'there-are-no-rules-description'
						),
						title: Liferay.Language.get('there-are-no-rules'),
					}}
					keywords={keywords}
					small
				/>
			) : (
				<div className="autofit-col rule-list">
					<hr />
					{filtereDataRules.map((rule, index) => (
						<RuleItem
							key={index}
							rule={rule}
							toggleRulesEditorVisibility={
								toggleRulesEditorVisibility
							}
						/>
					))}
				</div>
			)}
		</>
	);
};
