/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import PropTypes from 'prop-types';
import React, {useState} from 'react';

import AssetTagsSelector from './AssetTagsSelector.es';

function AssetTagsSelectorTag({
	addCallback,
	eventName,
	groupIds = [],
	id,
	initialInputValue,
	initialSelectedItems = [],
	inputName,
	label,
	portletURL,
	removeCallback,
	showSelectButton,
}) {
	const [selectedItems, setSelectedItems] = useState(initialSelectedItems);
	const [inputValue, setInputValue] = useState(initialInputValue);

	return (
		<AssetTagsSelector
			addCallback={addCallback}
			eventName={eventName}
			groupIds={groupIds}
			id={id}
			inputName={inputName}
			inputValue={inputValue}
			label={label}
			onInputValueChange={setInputValue}
			onSelectedItemsChange={setSelectedItems}
			portletURL={portletURL}
			removeCallback={removeCallback}
			selectedItems={selectedItems}
			showSelectButton={showSelectButton}
		/>
	);
}

AssetTagsSelectorTag.propTypes = {
	addCallback: PropTypes.string,
	eventName: PropTypes.string,
	groupIds: PropTypes.array,
	id: PropTypes.string,
	initialInputValue: PropTypes.string,
	initialSelectedItems: PropTypes.array,
	inputName: PropTypes.string,
	label: PropTypes.string,
	portletURL: PropTypes.string,
	removeCallback: PropTypes.string,
};

export default function(props) {
	return (
		<AssetTagsSelectorTag
			{...props}
			initialInputValue={props.inputValue}
			initialSelectedItems={props.selectedItems}
		/>
	);
}
