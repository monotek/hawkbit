/**
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.hawkbit.ui.management.targettag.filter;

import org.eclipse.hawkbit.ui.SpPermissionChecker;
import org.eclipse.hawkbit.ui.common.filterlayout.AbstractFilterHeader;
import org.eclipse.hawkbit.ui.management.event.ManagementUIEvent;
import org.eclipse.hawkbit.ui.management.state.ManagementUIState;
import org.eclipse.hawkbit.ui.utils.UIComponentIdProvider;
import org.eclipse.hawkbit.ui.utils.VaadinMessageSource;
import org.vaadin.spring.events.EventBus.UIEventBus;

import com.vaadin.ui.MenuBar.Command;

/**
 * Target Tag filter by Tag Header.
 */
public class TargetTagFilterHeader extends AbstractFilterHeader {

    private static final long serialVersionUID = 1L;

    private final ManagementUIState managementUIState;

    TargetTagFilterHeader(final VaadinMessageSource i18n, final ManagementUIState managementUIState,
            final SpPermissionChecker permChecker, final UIEventBus eventBus) {
        super(permChecker, eventBus, i18n);
        this.managementUIState = managementUIState;
    }

    @Override
    protected boolean doSubscribeToEventBus() {
        return false;
    }

    @Override
    protected String getHideButtonId() {
        return UIComponentIdProvider.HIDE_TARGET_TAGS;
    }

    @Override
    protected String getTitle() {
        return getI18n().getMessage("header.target.filter.tag");
    }

    @Override
    protected boolean dropHitsRequired() {

        return true;
    }

    @Override
    protected void hideFilterButtonLayout() {
        managementUIState.setTargetTagFilterClosed(true);
        getEventBus().publish(this, ManagementUIEvent.HIDE_TARGET_TAG_LAYOUT);
    }

    @Override
    protected String getConfigureFilterButtonId() {
        return null;
    }

    @Override
    protected boolean isAddTagRequired() {
        return false;
    }

    @Override
    protected Command getAddButtonCommand() {
        return null;
    }

    @Override
    protected Command getDeleteButtonCommand() {
        return null;
    }

    @Override
    protected Command getUpdateButtonCommand() {
        return null;
    }

    @Override
    protected String getMenuBarId() {
        return null;
    }

}
