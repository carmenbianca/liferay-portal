/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import {ClayButtonWithIcon} from '@clayui/button';
import ClayForm, {ClayInput} from '@clayui/form';
import ClayIcon from '@clayui/icon';
import PropTypes from 'prop-types';
import React, {useState} from 'react';

const STR_BLANK = '';

const DestinationUrlInput = ({
	autofocus = false,
	initialDestinationUrl = STR_BLANK,
	namespace,
}) => {
	const [requiredError, setRequiredError] = useState(false);
	const [destinationUrl, setDestinationUrl] = useState(initialDestinationUrl);

	const handleTryRedirection = () => {
		let testUrl = destinationUrl;
		const protocol = 'http';
		if (!testUrl.startsWith(protocol)) {
			testUrl = protocol + '://' + testUrl;
		}

		window.open(testUrl, '_blank');
	};

	return (
		<ClayForm.Group className={requiredError ? 'has-error' : STR_BLANK}>
			<label htmlFor={`${namespace}destinationURL`}>
				{Liferay.Language.get('destination-url')}

				<span className="inline-item-after reference-mark">
					<ClayIcon symbol={'asterisk'} />

					<span className="hide-accessible">
						{Liferay.Language.get('required')}
					</span>
				</span>
			</label>

			<ClayInput.Group>
				<ClayInput.GroupItem prepend>
					<ClayInput
						aria-label={Liferay.Language.get('destination-url')}
						autoFocus={autofocus}
						id={`${namespace}destinationURL`}
						name={`${namespace}destinationURL`}
						onBlur={({currentTarget}) =>
							setRequiredError(!currentTarget.value)
						}
						onChange={({currentTarget}) =>
							setDestinationUrl(currentTarget.value)
						}
						required
						type="text"
						value={destinationUrl}
					/>
				</ClayInput.GroupItem>
				<ClayInput.GroupItem append shrink>
					<ClayButtonWithIcon
						disabled={destinationUrl === STR_BLANK}
						displayType="secondary"
						onClick={handleTryRedirection}
						symbol="shortcut"
						title={Liferay.Language.get('try-redirection')}
					/>
				</ClayInput.GroupItem>
			</ClayInput.Group>

			{requiredError && (
				<ClayForm.FeedbackGroup>
					<ClayForm.FeedbackItem>
						{Liferay.Language.get('this-field-is-required')}
					</ClayForm.FeedbackItem>
				</ClayForm.FeedbackGroup>
			)}
		</ClayForm.Group>
	);
};

DestinationUrlInput.propTypes = {
	autofocus: PropTypes.bool,
	initialDestinationUrl: PropTypes.string,
	namespace: PropTypes.string.isRequired,
};

export default DestinationUrlInput;
