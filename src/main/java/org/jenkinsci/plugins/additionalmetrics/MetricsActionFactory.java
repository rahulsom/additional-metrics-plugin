package org.jenkinsci.plugins.additionalmetrics;

import hudson.Extension;
import hudson.model.Action;
import hudson.model.Job;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.Nonnull;
import jenkins.model.TransientActionFactory;
import org.kohsuke.stapler.export.Exported;
import org.kohsuke.stapler.export.ExportedBean;

@Extension
public class MetricsActionFactory extends TransientActionFactory<Job> {
    @Override
    public Class<Job> type() {
        return Job.class;
    }

    @Nonnull
    @Override
    public Collection<? extends Action> createFor(@Nonnull Job target) {
        return Collections.singleton(new MetricsAction(target));
    }

    @ExportedBean
    public static class MetricsAction implements Action {
        private final Job target;

        MetricsAction(Job target) {
            this.target = target;
        }

        @Override
        public String getIconFileName() {
            return null;
        }

        @Override
        public String getDisplayName() {
            return null;
        }

        @Override
        public String getUrlName() {
            return null;
        }

        @Exported
        public JobMetrics getJobMetrics() {
            return new JobMetrics(target);
        }
    }
}
