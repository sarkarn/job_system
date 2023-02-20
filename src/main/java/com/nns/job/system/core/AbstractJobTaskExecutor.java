package com.nns.job.system.core;

public abstract class AbstractJobTaskExecutor {
    private Task task;

    public AbstractJobTaskExecutor(Task task){
        this.task = task;
    }

    final JobTaskResult executeWith(JobTaskInstanceLifeCycleCallback lifeCycleCallback)
    throws Exception{
        JobTaskResult jobTaskResult = null;

        for(int i=0; i<3 ; i++ ){
            try {
                lifeCycleCallback.onStart();
                jobTaskResult = task.execute();
                lifeCycleCallback.onEnd();
                JobTaskInstancePostExecuteCallback jobTaskInstancePostExecuteCallback
                        = task.getJobTaskInstancePostExecuteCallback();
                if (jobTaskInstancePostExecuteCallback != null) {
                    jobTaskInstancePostExecuteCallback.postJobTaskExecute(task.getJobTaskInstance());
                }
                break;
            }catch(Exception ex){
                ex.printStackTrace();
                //Max Retry limit reached
                if(i==2){
                    lifeCycleCallback.onError(ex);
                    throw ex;
                }
                //Wait 30 seconds before next retry
                Thread.sleep(30*1000);
            }
        }
        return jobTaskResult;
    }
}
