/// <reference path="./.sst/platform/config.d.ts" />

export default $config({
  app(input) {
    return {
      name: 'restApiAuthDemo',
      removal: input?.stage === 'production' ? 'retain' : 'remove',
      home: 'aws',
    };
  },
  async run() {
    const vpc = new sst.aws.Vpc('Articles');

    const cluster = new sst.aws.Cluster('ArticlesXeus', { vpc });

    cluster.addService('ArticlesService', {
      public: {
        ports: [
          {
            listen: '80/http',
          },
        ],
      },
    });
  },
});
