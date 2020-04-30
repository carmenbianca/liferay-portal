/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import ClayButton from '@clayui/button';
import ClayForm, {ClayInput} from '@clayui/form';
import {getConnectedReactComponentAdapter} from 'dynamic-data-mapping-form-field-type';
import {ItemSelectorDialog} from 'frontend-js-web';
import React, {useEffect, useState} from 'react';

import templates from './JournalArticleSelectorAdapter.soy';

const JournalArticleSelectorWithState = ({
	dispatch,
	inputValue,
	itemSelectorURL,
	name,
	portletNamespace,
	readOnly,
}) => {
	const [article, setArticle] = useState({});

	useEffect(() => {
		setArticle({
			...JSON.parse(inputValue || '{}'),
		});
	}, [inputValue]);

	const _dispatchValue = (value, clear) => {
		setArticle(() => {
			dispatch({
				payload: clear ? '' : JSON.stringify(value),
				type: 'value',
			});

			return value;
		});
	};

	const _handleClearClick = () => {
		_dispatchValue({}, true);
	};

	const _handleFieldChanged = event => {
		const selectedItem = event.selectedItem;

		if (selectedItem && selectedItem.value) {
			setArticle(() => {
				dispatch({
					payload: selectedItem.value,
					type: 'value',
				});

				return selectedItem.value;
			});
		}
	};

	const _handleItemSelectorTriggerClick = event => {
		event.preventDefault();

		const itemSelectorDialog = new ItemSelectorDialog({
			eventName: `${portletNamespace}selectJournalArticle`,
			singleSelect: true,
			title: Liferay.Language.get('journal-article'),
			url: itemSelectorURL,
		});

		itemSelectorDialog.on('selectedItemChange', _handleFieldChanged);

		itemSelectorDialog.open();
	};

	return (
		<>
			<ClayForm.Group style={{marginBottom: '0.5rem'}}>
				<ClayInput.Group>
					<ClayInput.GroupItem className="d-none d-sm-block" prepend>
						<input name={name} type="hidden" value={inputValue} />

						<ClayInput
							className="bg-light"
							disabled={readOnly}
							onClick={_handleItemSelectorTriggerClick}
							readOnly
							type="text"
							value={article.title || ''}
						/>
					</ClayInput.GroupItem>

					<ClayInput.GroupItem append shrink>
						<ClayButton
							disabled={readOnly}
							displayType="secondary"
							onClick={_handleItemSelectorTriggerClick}
							type="button"
						>
							{Liferay.Language.get('select')}
						</ClayButton>
					</ClayInput.GroupItem>

					{article.classPK && (
						<ClayInput.GroupItem shrink>
							<ClayButton
								disabled={readOnly}
								displayType="secondary"
								onClick={_handleClearClick}
								type="button"
							>
								{Liferay.Language.get('clear')}
							</ClayButton>
						</ClayInput.GroupItem>
					)}
				</ClayInput.Group>
			</ClayForm.Group>
		</>
	);
};

const ReactJournalArticleSelectorAdapter = getConnectedReactComponentAdapter(
	JournalArticleSelectorWithState,
	templates
);

export {ReactJournalArticleSelectorAdapter};
export default ReactJournalArticleSelectorAdapter;
