/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import '@testing-library/jest-dom/extend-expect';
import {
	cleanup,
	fireEvent,
	render,
	waitForElement,
} from '@testing-library/react';
import React from 'react';
import {act} from 'react-dom/test-utils';

import Checkin from '../../../../src/main/resources/META-INF/resources/document_library/js/checkin/Checkin.es';

const bridgeComponentId = '_portletNamespace_DocumentLibraryCheckinModal';
const dlVersionNumberIncreaseValues = {
	MAJOR: 'MAJOR',
	MINOR: 'MINOR',
	NONE: 'NONE',
};

function _renderCheckinComponent({checkedOut = true} = {}) {
	return render(
		<Checkin
			checkedOut={checkedOut}
			dlVersionNumberIncreaseValues={dlVersionNumberIncreaseValues}
			portletNamespace="portletNamespace"
		/>,
		{
			baseElement: document.body,
		}
	);
}

describe('Checkin', () => {
	const components = {};
	Liferay.component = (id, component) => {
		components[id] = component;
	};
	Liferay.componentReady = id => Promise.resolve(components[id]);
	afterEach(cleanup);

	describe('when the file is checked out', () => {
		describe('and the component is rendered', () => {
			let result;
			beforeEach(() => {
				result = _renderCheckinComponent();
			});

			describe('and we call the open method on the bridge component', () => {
				let callback;
				beforeEach(() => {
					callback = jest.fn();

					return act(() =>
						Liferay.componentReady(bridgeComponentId).then(
							({open}) => {
								open(callback);
							}
						)
					);
				});

				it('renders the form', async () => {
					const form = await waitForElement(() =>
						result.getByRole('form')
					);
					expect(form);
				});

				describe('and the form is submitted', () => {
					beforeEach(async () => {
						const form = await waitForElement(() =>
							result.getByRole('form')
						);
						act(() => {
							fireEvent.submit(form);
						});
					});

					it('the callback is called with the major version', () => {
						expect(callback).toHaveBeenCalledWith(
							dlVersionNumberIncreaseValues.MAJOR,
							''
						);
					});
				});

				describe('and the save button is cliked with changes in version and changeLog', () => {
					beforeEach(async () => {
						const saveButton = await waitForElement(() =>
							result.getByText('save')
						);
						const changeLogField = await waitForElement(() =>
							result.getByLabelText('version-notes')
						);
						const minorVersionRadio = await waitForElement(() =>
							result.getByLabelText('minor-version')
						);

						act(() => {
							fireEvent.change(changeLogField, {
								target: {value: 'ChangeLog notes'},
							});
							fireEvent.click(minorVersionRadio);
						});

						act(() => {
							fireEvent.click(saveButton);
						});
					});

					it('the callback is called with the minor version and version notes', () => {
						expect(callback).toHaveBeenCalledWith(
							dlVersionNumberIncreaseValues.MINOR,
							'ChangeLog notes'
						);
					});
				});
			});
		});
	});

	describe('when the file is not checked out', () => {
		describe('and the component is rendered', () => {
			let result;
			beforeEach(() => {
				result = _renderCheckinComponent({checkedOut: false});
			});

			describe('and we call the open method on the bridge component', () => {
				let callback;
				beforeEach(() => {
					callback = jest.fn();

					return act(() =>
						Liferay.componentReady(
							bridgeComponentId
						).then(({open}) => open(callback))
					);
				});

				it('renders the form', async () => {
					const form = await waitForElement(() =>
						result.getByRole('form')
					);
					expect(form);
				});

				describe('and the form is submitted', () => {
					beforeEach(async () => {
						const form = await waitForElement(() =>
							result.getByRole('form')
						);
						act(() => {
							fireEvent.submit(form);
						});
					});

					it('the callback is called with the major version', () => {
						expect(callback).toHaveBeenCalledWith(
							dlVersionNumberIncreaseValues.MINOR,
							''
						);
					});
				});
			});
		});
	});
});
