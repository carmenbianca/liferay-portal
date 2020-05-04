/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import '../SuccessPage/SuccessPage.es';

import {PagesVisitor, compose} from 'dynamic-data-mapping-form-renderer';
import FormRenderer from 'dynamic-data-mapping-form-renderer/js/components/FormRenderer/FormRenderer.es';
import Component from 'metal-jsx';
import {Config} from 'metal-state';

import {pageStructure} from '../../util/config.es';
import withActionableFields from './withActionableFields.es';
import withClickableFields from './withClickableFields.es';
import withEditablePageHeader from './withEditablePageHeader.es';
import withMoveableFields from './withMoveableFields.es';
import withMultiplePages from './withMultiplePages.es';
import withResizeableColumns from './withResizeableColumns.es';

/**
 * Builder.
 * @extends Component
 */

class FormBuilderBase extends Component {
	attached() {
		const formBasicInfo = document.querySelector('.ddm-form-basic-info');
		const translationManager = document.querySelector(
			'.ddm-translation-manager'
		);

		if (formBasicInfo && translationManager) {
			formBasicInfo.classList.remove('hide');
			translationManager.classList.remove('hide');
		}
	}

	preparePagesForRender(pages) {
		const visitor = new PagesVisitor(pages);

		return visitor.mapFields(field => {
			if (
				field.type === 'select' &&
				!field.dataSourceType.includes('manual')
			) {
				field = {
					...field,
					options: [
						{
							label: Liferay.Language.get(
								'dynamically-loaded-data'
							),
							value: 'dynamic',
						},
					],
					value: 'dynamic',
				};
			}

			return {
				...field,
				readOnly: true,
			};
		});
	}

	render() {
		const {props} = this;
		const {
			activePage,
			editingLanguageId,
			pages,
			paginationMode,
			portletNamespace,
			spritemap,
		} = props;

		return (
			<div class="ddm-form-builder-wrapper">
				<div class="container ddm-form-builder">
					<div class="sheet">
						<FormRenderer
							activePage={activePage}
							editable={true}
							editingLanguageId={editingLanguageId}
							pages={this.preparePagesForRender(pages)}
							paginationMode={paginationMode}
							portletNamespace={portletNamespace}
							ref="FormRenderer"
							spritemap={spritemap}
						/>
					</div>
				</div>
			</div>
		);
	}
}

FormBuilderBase.PROPS = {
	/**
	 * @default
	 * @instance
	 * @memberof FormBuilder
	 * @type {?number}
	 */

	activePage: Config.number().value(0),

	/**
	 * @default undefined
	 * @instance
	 * @memberof FormBuilder
	 * @type {?string}
	 */

	defaultLanguageId: Config.string(),

	/**
	 * @default undefined
	 * @instance
	 * @memberof FormBuilder
	 * @type {?string}
	 */

	editingLanguageId: Config.string(),

	/**
	 * @default []
	 * @instance
	 * @memberof FormBuilder
	 * @type {?array<object>}
	 */

	pages: Config.arrayOf(pageStructure).value([]),

	/**
	 * @instance
	 * @memberof FormBuilder
	 * @type {string}
	 */

	paginationMode: Config.string().required(),

	/**
	 * @instance
	 * @memberof FormBuilder
	 * @type {string}
	 */

	portletNamespace: Config.string().required(),

	/**
	 * @default undefined
	 * @instance
	 * @memberof FormBuilder
	 * @type {!string}
	 */

	spritemap: Config.string().required(),

	/**
	 * @instance
	 * @memberof FormBuilder
	 * @type {object}
	 */

	successPageSettings: Config.shapeOf({
		body: Config.object(),
		enabled: Config.bool(),
		title: Config.object(),
	}).value({}),

	/**
	 * @default undefined
	 * @instance
	 * @memberof FormBuilder
	 * @type {?string}
	 */

	view: Config.string(),
};

export default compose(
	withActionableFields,
	withClickableFields,
	withEditablePageHeader,
	withMoveableFields,
	withMultiplePages,
	withResizeableColumns
)(FormBuilderBase);

export {FormBuilderBase};
