# A demo application for testing the use of a configMap the OpenShift environment. 


## Steps to using oc to create a configMap containing a single property used in the application. 

1. Log into OpenShift. Click the cog in the top right corner of the console. Copy the oc login command and paste it into a command window on your local machine.
2. Once signed in, create the new configMap and set a new name value pair with: 
```
    oc create configmap greeter-props --from-literal greeter.prefix=Bonjour
```
3. List the new configMap with: 
```
    oc get configmap/greeter-props -o json
{
    "apiVersion": "v1",
    "data": {
        "greeter.prefix": "Bonjour"
    },
    "kind": "ConfigMap",
    "metadata": {
        "creationTimestamp": "2019-03-29T22:54:05Z",
        "name": "greeter-props",
        "namespace": "ag-devops-lab-deploy",
        "resourceVersion": "716868495",
        "selfLink": "/api/v1/namespaces/ag-devops-lab-deploy/configmaps/greeter-props",
        "uid": "8e078e41-5275-11e9-9c9b-0050568348cc"
    }
}
```
4. When a config map is created, it is not associated with any application. To pass the settings in this config map as environment variables in a deployment configuration, you need to run the extra step of:
```
    oc set env dc/greeterapp --from configmap/greeter-props
```    
5. Redeply the application to pick up the new property. Test with 
```
    https://openshift-endpoint/greet/myName
```
Result should show: 
```
   Bonjour Shaun, blah blah... (Note the Bonjour word was picked from the property in the configMap) 
```




# Additional information on reading Environment Variables

http://v1.uncontained.io/playbooks/app_dev/properties-management.html#using-environment-variables


